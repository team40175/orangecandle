Ext.define('OrangeCandle.controller.Login', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			loginView : 'loginview',
			mainMenuView : 'mainmenuview',
			logOff : 'navigationview button[action="logOff"]',
			showLessons : 'mainmenuview button[action="showSchedule"]'
		},
		control : {
			loginView : {
				signInCommand : 'onSignInCommand'
			},
			'logOff' : {
				tap : 'logOff'
			},
			'#changePass' : {
				tap : 'changePassword'
			},
			'showLessons' : {
				tap : 'scheduleShow'
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
		Ext.Viewport.setActiveItem(0);
		Ext.Msg.alert("", "You are logged off.", Ext.emptyFn);
	},
	changePassword : function() {
		var main = this.getMainMenuView();
		main.push({
			xtype : 'changepassword'
		});
	},
	scheduleShow : function() {
		var main = this.getMainMenuView();
		main.push({
			xtype : 'viewlessons'
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
				var view = {
					xtype : 'mainmenuview'
				};
				var data = JSON.parse(response.responseText).data;
				if (data.length === 0) {
					Ext.Msg.alert("",
							"You have no role bound to your account.",
							Ext.emptyFn);
					return;
				}
				Ext.Viewport.add(view);
				var mainView = Ext.Viewport.down('mainmenuview');
				Ext.Viewport.setActiveItem(mainView);
				mainView.getLayout().setAnimation(false);
				mainView.down('panel').removeAll();
				me.createButtons(mainView, "All");
				for ( var i in data) {
					me.createButtons(mainView, data[i].id);
				}
			},
			failure : function(response) {
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			}
		});
	},
	createButtons : function(view, role) {
		var buttons = Ext.StoreManager.lookup('Buttons').data.items[0].data;
		if (buttons[role]) {
			view.down('panel').add(buttons[role]);
		}
	}
});
