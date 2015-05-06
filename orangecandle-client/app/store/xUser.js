Ext.define('OrangeCandle.store.xUser', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.xUser',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
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