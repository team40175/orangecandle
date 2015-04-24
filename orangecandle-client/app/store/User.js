Ext.define('OrangeCandle.store.User', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.User',
		proxy : {
			type : 'ajax',
			url : "http://localhost:8080/user/findAll",
			reader : {
				type : "json",
				rootProperty: "data"
			}
		},
		autoLoad : true
	}
});