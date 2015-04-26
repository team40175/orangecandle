Ext
		.define(
				'OrangeCandle.view.Login',
				{
					extend : 'Ext.form.Panel',
					alias : "widget.loginview",
					requires: ['Ext.form.FieldSet', 'Ext.form.Password', 'Ext.Label', 'Ext.Img', 'Ext.util.DelayedTask','Ext.MessageBox'],
					config : {
						title : 'Login',
						items : [
								{
									xtype : 'image',
									src : 'http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/3d-transparent-glass-icons-business/076082-3d-transparent-glass-icon-business-lock6-sc48.png',
									style : Ext.Viewport.getOrientation() == 'portrait' ? 'width:100px;height:100px;margin:auto'
											: 'width:100px;height:100px;margin:auto'
								},
								{

									xtype : 'label',
									html : 'Login failed. Please enter the correct credentials.',
									itemId : 'signInFailedLabel',
									hidden : true,
									hideAnimation : 'fadeOut',
									showAnimation : 'fadeIn',
									style : 'color:#990000;margin:5px 0px;'
								}, {
									xtype : 'fieldset',
									title : 'Login',
									items : [ {
										xtype : 'textfield',
										placeHolder : 'Username',
										itemId : 'userNameTextField',
										name : 'userNameTextField',
										required : true
									}, {

										xtype : 'passwordfield',
										placeHolder : 'Password',
										itemId : 'passwordTextField',
										name : 'passwordTextField',
										required : true
									} ]

								}, {
									xtype : 'button',
									itemId : 'logInButton',
									ui : 'action',
									padding : '10px',
									text : 'Log In'
								}

						],
						listeners : [ {
							delegate : '#logInButton',
							event : 'tap',
							fn : 'onLogInButtonTap'
						} ],
						
					},
					onLogInButtonTap: function () {

				        var me = this,
				            usernameField = me.down('#userNameTextField'),
				            passwordField = me.down('#passwordTextField'),
				            label = me.down('#signInFailedLabel'),
				            username = usernameField.getValue(),
				            password = passwordField.getValue();

				        label.hide();

				        // Using a delayed task in order to give the hide animation above
				        // time to finish before executing the next steps.
				        var task = Ext.create('Ext.util.DelayedTask', function () {

				            label.setHtml('');

				            me.fireEvent('signInCommand', me, username, password);

				            usernameField.setValue('');
				            passwordField.setValue('');
				        });

				        task.delay(500);

				    },
						showSignInFailedMessage : function(message) {
							var label = this.down('#signInFailedLabel');
							label.setHtml(message);
							label.show();
						}
					
				});
