Ext.define('OrangeCandle.store.xUser', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.xUser',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("user/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});