Ext.define('OrangeCandle.store.Faculty', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Faculty',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("faculty/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});