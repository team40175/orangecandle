Ext.define('OrangeCandle.util.Scalability', {
	singleton : true,
	getApplicationServer : function(target) {
		 return "http://25.52.208.233:8080/" + target;
//		return "http://localhost:8080/" + target;
	}
});