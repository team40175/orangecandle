Ext.define('OrangeCandle.store.School', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.School',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
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