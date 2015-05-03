Ext.define('OrangeCandle.store.Room', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Room',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("room/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});