Ext.define('OrangeCandle.controller.Main', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'mainmenuview' : {
				painted : 'onPainted'
			}
		}
	},
	onPainted : function() {
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability
					.getApplicationServer('user/findRoles'),
			params : {
				username : OrangeCandle.util.Auth.getUsername()
			},
			success : function(response, data) {
				console.log("Spiffing, everything worked");
				data.forEeach(function(role) {
					if (role === 'Administrator') {
						this.add([])
					}
				})
			},
			failure : function(response) {
				console.log("Curses, something terrible happened");
			},
		});
	}
});