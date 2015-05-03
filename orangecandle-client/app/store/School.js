Ext.define('OrangeCandle.store.School', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.,School',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("school/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});