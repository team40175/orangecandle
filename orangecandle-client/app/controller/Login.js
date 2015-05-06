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
		OrangeCandle.util.Auth.set(username, password);
		view.submit({
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			url : OrangeCandle.util.Scalability.getApplicationServer("login"),
			method : 'POST',
			success : function(form, result) {
				Ext.Msg.alert('', result.message, function() {
					me.signInSuccess();
				});
			},
			failure : function(form, result) {
				me.signInFailure();
			}
		});
	},
	signInSuccess : function() {
		var loginView = this.getLoginView().setMasked(false);
		Ext.Viewport.setActiveItem(this.getMainMenuView());
	},
	signInFailure : function(message) {
		this.getLoginView().setMasked(false);
		Ext.Msg.alert("", "Sign in failed", Ext.emptyFn);
	}
});
