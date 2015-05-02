Ext.define('OrangeCandle.controller.Button', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			'button[ref]' : {
				tap : 'onClick'
			}
		}
	},
	onClick : function(button, event, opts) {
		if (button.ref.store !== undefined)
			Ext.data.StoreManager.lookup(button.ref.store).load();
		this.getMainView().push(button.ref);
	}
});