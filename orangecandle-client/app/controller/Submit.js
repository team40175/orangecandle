Ext.define('OrangeCandle.controller.Submit', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			'button[target]' : {
				tap : 'onClick'
			}
		}
	},
	onClick : function(button, event, options) {
		button.up('panel').submit(
				{
					headers : {
						Authorization : OrangeCandle.util.Auth.get()
					},
					url : OrangeCandle.util.Scalability
							.getApplicationServer(button.target),
					method : 'POST',
					success : function(form, result) {
						Ext.Msg.alert('', result.message, function() {
							this.getMainView().pop()
						});
					},
					failure : function(form, result) {
						Ext.Msg.alert(result.message);
					}
				});
	}
})