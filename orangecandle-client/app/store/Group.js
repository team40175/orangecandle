Ext.define('OrangeCandle.store.Group', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Group',
		proxy : {
			type : 'ajax',
			actionMethods : {
				create : 'POST',
				read : 'POST', // by default GET
				update : 'POST',
				destroy : 'POST'
			},
			url : "http://localhost:8080/group/findAll",
			reader : {
				type : "json"
			}
		},
		autoLoad : true
	}
});