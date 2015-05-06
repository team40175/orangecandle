Ext.define('OrangeCandle.store.Constraint', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Constraint',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("constraint/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});