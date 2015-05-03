Ext.define('OrangeCandle.view.Main', {
	extend : 'Ext.navigation.View',
	alias : 'widget.mainmenuview',
	requires : [ 'Ext.TitleBar' ],
	config : {
		navigationBar : {
			docked : 'top',
			items : [ {
				xtype : 'button',
				text : 'Log Off',
				itemId : 'logOffButton',
				align : 'right'
			} ]
		},
		items : [ {
			xtype : 'panel',
			items : [
			{
				xtype : 'button',
				text : 'Lessons',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Lesson',
//					extraStore : 'Group'
				},
				form : {
					xtype : 'addlesson',
				}
			}, {
				xtype : 'button',
				text : 'Classrooms',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Room',
//					extraStore : 'Group'
				},
				form : {
					xtype : 'addclassroom',
				}
			}, {
				xtype : 'button',
				text : 'Constraints',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Constraints',
//					extraStore : 'Group'
				},
				form : {
					xtype : 'addconstraints',
				}
			}, {
				xtype : 'button',
				text : 'Schools',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'School',
//					extraStore : 'Group'
				},
				form : {
					xtype : 'addschool',
				}
			}, {
				xtype : 'button',
				text : 'Users',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
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
					mode : 'multi',
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
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Role'
				}
			} ]
		} ]
	}
});
