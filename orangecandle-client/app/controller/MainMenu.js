Ext.define('OrangeCandle.controller.MainMenu', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			MainView : {
				painted : 'onPainted'
			}
		}
	},
	onPainted : function() {
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability
					.getApplicationServer('user/find'),
			params : {
				username : OrangeCandle.util.Auth.getUsername()
			},

			success : function(response, data) {
				console.log("Spiffing, everything worked");
				data.forEeach(function(role) {
					if (role === 'Administrator') {
						this.add([// buttons
						])
					}
				})
			},

			failure : function(response) {
				console.log("Curses, something terrible happened");
			},
		});
	}
});