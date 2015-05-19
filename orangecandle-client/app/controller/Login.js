Ext.define('OrangeCandle.controller.Login', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			loginView : 'loginview',
			mainMenuView : 'mainmenuview',
		},
		control : {
			loginView : {
				signInCommand : 'onSignInCommand'
			},
			'#logOut' : {
				tap : 'logOff'
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
		Ext.Viewport.setActiveItem(login);
		Ext.Msg.alert("", "You are logged off.", Ext.emptyFn);
	},
	onShow : function() {
		var main = this.getMainMenuView();
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability
					.getApplicationServer('user/findRoles'),
			method : 'get',
			params : {
				username : OrangeCandle.util.Auth.getUsername()
			},

			success : function(response) {
				main.down('panel').removeAll();
				console.log("Spiffing, everything worked");
				var data = JSON.parse(response.responseText).data;
				if(data.length === 0){
					Ext.Msg.alert("", "You have no role bound to your account.", Ext.emptyFn);
					return 
				}
				for ( var i in data) {
					if (data[i].id === 'Administrator') {
						main.down('panel').add([ {
							xtype : 'button',
							text : 'Lessons',
							ref : {
								xtype : 'list',
								itemTpl : '{name}',
								store : 'Lecture',
							},
							form : {
								xtype : 'addlesson',
							}
						}, {
							xtype : 'button',
							text : 'Classrooms',
							ref : {
								xtype : 'list',
								itemTpl : '{name}',
								store : 'Room',
							},
							form : {
								xtype : 'addclassroom',
							}
						}, {
							xtype : 'button',
							text : 'Constraints',
							ref : {
								xtype : 'list',
								itemTpl : '{name}',
								store : 'Constraint',
							},
							form : {
								xtype : 'addconstraints',
							}
						}, {
							xtype : 'button',
							text : 'Schools',
							ref : {
								xtype : 'list',
								itemTpl : '{name}',
								store : 'School',
							},
							form : {
								xtype : 'addschool',
							}
						}, {
							xtype : 'button',
							text : 'Users',
							ref : {
								xtype : 'list',
								itemTpl : '{username}',
								store : 'xUser',
								alias : 'User',
								extraStore : 'Group'
							},
							form : {
								xtype : 'addaccount',
							}
						}, {
							xtype : 'button',
							text : 'Groups',
							ref : {
								xtype : 'list',
								itemTpl : '{name}',
								store : 'Group',
								extraStore : 'Role'
							},
							form : {
								xtype : 'addgroups',
							}
						}, {
							xtype : 'button',
							text : 'Roles',
							ref : {
								xtype : 'list',
								indelible : true,
								itemTpl : '{name}',
								store : 'Role'
							}
						} ])
					}
				}
				Ext.Viewport.setActiveItem(main);
			},

			failure : function(response) {
				Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
			},
		});
	}
});
