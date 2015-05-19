Ext.define('OrangeCandle.controller.Main', {
	extend : 'Ext.app.Controller',
	config : {
		control : {
			'mainmenuview' : {
				show : 'onPainted'
			}
		}
	},
	onPainted : function() {
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability
					.getApplicationServer('user/findRoles'),
			method : 'get',
			params : {
				username : OrangeCandle.util.Auth.getUsername()
			},
			success : function(response, data) {
				data.forEach(function(role) {
					if (role === 'Administrator') {
						this.add([])
					}
				})
			},
			failure : function(response) {
			},
		});
	}
});