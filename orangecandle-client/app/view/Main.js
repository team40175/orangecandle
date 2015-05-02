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
			items : [ {
				xtype : 'button',
				text : 'Add an Account',
				ref : {
					xtype : 'addaccount',
				},
			}, {
				xtype : 'button',
				text : 'Add a Lesson',
				ref : {
					xtype : 'addlesson',
				}
			}, {
				xtype : 'button',
				text : 'Add a Classroom',
				ref : {
					xtype : 'addclassroom',
				}
			}, {
				xtype : 'button',
				text : 'Add Constraints',
				ref : {
					xtype : 'addconstraints',
				}
			}, {
				xtype : 'button',
				text : 'Add a School',
				ref : {
					xtype : 'addschool',
				}
			}, {
				xtype : 'button',
				text : 'Users',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'User'
				}
			}, {
				xtype : 'button',
				text : 'Groups',
				ref : {
					xtype : 'list',
					mode : 'multi',
					itemTpl : '{name}',
					store : 'Group'
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
