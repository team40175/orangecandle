
Ext.define('OrangeCandle.store.Teacher', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.xUser',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("user/findTeachers"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});