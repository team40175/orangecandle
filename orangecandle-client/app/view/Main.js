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
				text : 'Add a Group',
				ref : {
					xtype : 'addgroups',
				},
				handler : function() {
					Ext.data.StoreManager.lookup('Role').load()
				}
			}, {
				xtype : 'button',
				text : 'Add an Account',
				ref : {
					xtype : 'addaccount',
				},
				handler : function() {
					Ext.data.StoreManager.lookup('Group').load()
				}
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
				}
			} ]
		} ]
	}
});
