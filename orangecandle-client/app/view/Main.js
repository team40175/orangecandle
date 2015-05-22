Ext.define('OrangeCandle.view.Main', {
	extend : 'Ext.navigation.View',
	alias : 'widget.mainmenuview',
	requires : [ 'Ext.TitleBar' ],
	config : {
		ui : 'plain',
		navigationBar : {
			docked : 'top',
			items : [ {
				xtype : 'button',
				text : 'Log Off',
				action : 'logOff',
				align : 'right'
			} ]
		},
		items : [ {
			xtype : 'panel'
		} ]
	}
});
