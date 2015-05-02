Ext.define('OrangeCandle.store.User', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Group',
		proxy : {
			type : 'ajax',
			url : OrangeCandle.util.Scalability.getApplicationServer("/user/findAll"),
			reader : {
				type : "json",
//				rootProperty: "data"
			}
		},
		autoLoad : true
	}
});