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
			}
		}
	},
	onSignInCommand : function(view, username, password) {
		var me = this, loginView = me.getLoginView();
		if (username.length === 0 || password.length === 0) {
			loginView.showSignInFailedMessage('You need to enter something');
			return;
		}

		loginView.setMasked({
			xtype : 'loadmask',
			message : 'Signing In...'
		});
		me.signInSuccess();
	},
	signInSuccess : function() {
		var loginView = this.getLoginView();
		mainMenuView = this.getMainMenuView();
		loginView.setMasked(false);
		Ext.Viewport.setActiveItem(mainMenuView);
	},
	signInFailure : function(message) {
		var loginView = this.getLoginView();
		loginView.showSignInFailedMessage(message);
		loginView.setMasked(false);
	}
});
