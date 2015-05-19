Ext.define('OrangeCandle.store.Department', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Department',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("department/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});