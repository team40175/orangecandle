Ext.define('OrangeCandle.store.Role', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Role',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("group/getRoles"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});