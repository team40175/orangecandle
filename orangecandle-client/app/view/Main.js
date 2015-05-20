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
				id : 'logOut',
				align : 'right'
			}, {
				xtype : 'button',
				text : 'ChangePassword',
				id : 'changePass'
			} ]
		},
		items : [ {
			xtype : 'panel'
		} ]

	}
});
