Ext.define('OrangeCandle.store.Buttons', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Buttons',
		proxy : {
			type : 'ajax',
			url : 'app/data/buttons.json',
			reader : {
				type : "json",
			}
		},
		autoLoad : true
	}
});