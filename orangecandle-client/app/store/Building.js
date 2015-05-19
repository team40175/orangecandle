Ext.define('OrangeCandle.store.Building', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Building',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("building/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});