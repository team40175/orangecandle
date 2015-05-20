Ext.define('OrangeCandle.controller.Login', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			loginView : 'loginview',
			mainMenuView : 'mainmenuview'
		},
		control : {
			loginView : {
				signInCommand : 'onSignInCommand'
			},
			'#logOut' : {
				tap : 'logOff'
			},
			'#changePass' : {
				tap : 'changePassword'
			}
		}
	},
	onSignInCommand : function(view, username, password) {
		var me = this;
		var loginView = this.getLoginView();
		var main = this.getMainMenuView();
		if (username.length === 0 || password.length === 0) {
			Ext.Msg.alert('', 'You need to enter something', Ext.emptyFn);
			return;
		}
		loginView.setMasked({
			xtype : 'loadmask',
			message : 'Signing In...'
		});
		OrangeCandle.util.Auth.set(username, password);
		view.submit({
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			url : OrangeCandle.util.Scalability.getApplicationServer("login"),
			method : 'POST',
			success : function(form, result) {
				me.onShow();
				loginView.setMasked(false);
			},
			failure : function(form, result) {
				loginView.setMasked(false);
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			}
		});
	},
	logOff : function() {
		var login = this.getLoginView();
		Ext.Viewport.pop();
		Ext.Msg.alert("", "You are logged off.", Ext.emptyFn);
	},
	changePassword : function() {
		var main = this.getMainMenuView();
		main.push({
			xtype : 'changepassword'
		});
	},
	onShow : function() {
		var me = this
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability
					.getApplicationServer('user/findRoles'),
			method : 'get',
			params : {
				username : OrangeCandle.util.Auth.getUsername()
			},

			success : function(response) {
				console.log("Spiffing, everything worked");
				var data = JSON.parse(response.responseText).data;
				if (data.length === 0) {
					Ext.Msg.alert("",
							"You have no role bound to your account.",
							Ext.emptyFn);
					return;
				}
				for ( var i in data) {
					me.createButtons(data[i].id);
				}
				Ext.Viewport.add({
					xtype : 'mainmenuview'
				});
				Ext.Viewport.setActiveItem(1);
			},

			failure : function(response) {
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			},
		});
	},
	createButtons : function(role) {
		var main = this.getMainMenuView();
		var buttons = Ext.StoreManager.lookup('Buttons').data.items[0].data;
		if (buttons[role]) {
			main.down('panel').add(buttons[role]);
		}
	}
});
