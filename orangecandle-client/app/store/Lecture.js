Ext.define('OrangeCandle.store.Lecture', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Lecture',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("lecture/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});