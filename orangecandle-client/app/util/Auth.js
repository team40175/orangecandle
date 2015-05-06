Ext.define('OrangeCandle.util.Auth', {
	singleton : true,
	set : function(username, password) {
		this.auth = 'Basic ' + btoa(username + ':' + password);
	},
	get : function() {
		return this.auth;
	}
});