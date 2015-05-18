Ext.define('OrangeCandle.controller.MainMenu', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			mainView : {
				show : 'onShow'
			}
		}
	},
	onShow : function() {
		var main = this.getMainView();
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
			},

			failure : function(response) {
				console.log("Curses, something terrible happened");
			},
		});
	}
});