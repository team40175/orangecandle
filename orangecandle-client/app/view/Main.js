Ext.define('OrangeCandle.view.Main',
		{
			extend : 'Ext.navigation.View',
			alias : 'widget.mainmenuview',

			requires : [ 'Ext.TitleBar', ],
			config : {
				navigationBar : {
					title : 'Welcome,'
							+ Ext.ComponentQuery.query('#userNameTextField'),
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
						itemId : 'groupButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addgroups',
							})
						}
					}, {
						xtype : 'button',
						text : 'Add an Account',
						itemId : 'accountButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addaccount',
							})
						}
					}, {
						xtype : 'button',
						text : 'Add a Lesson',
						itemId : 'LessontButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addlesson',
							})
						}
					} ,{
						xtype : 'button',
						text : 'Add a Classroom',
						itemId : 'ClassroomButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addclassroom',
							})
						}
					},{
						xtype : 'button',
						text : 'Add Constraints',
						itemId : 'constraintsButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addconstraints',
							})
						}
					},{
						xtype : 'button',
						text : 'Add a School',
						itemId : 'schoolButton',
						flex : 1,
						handler : function() {
							Ext.ComponentQuery.query('mainmenuview')[0].push({
								xtype : 'addschool',
							})
						}
					}]
				} ],
				listeners : [ {
					delegate : '#logOffButton',
					event : 'tap',
					fn : 'onLogOffButtonTap'
				}, {

				} ]

			},
			onLogOffButtonTap : function() {
				this.fireEvent('onSignOffCommand');
			}
		});
