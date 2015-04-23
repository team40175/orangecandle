Ext.define('OrangeCandle.store.Group', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Group',
		proxy : {
			type : 'ajax',
			url : "http://localhost:8080/group/findAll",
			reader : {
				type : "json"
			}
		},
		autoLoad : true
	}
});