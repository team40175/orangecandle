Ext.define('OrangeCandle.store.Group', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Group',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("group/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});