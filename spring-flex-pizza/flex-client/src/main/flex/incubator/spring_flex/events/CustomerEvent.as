package incubator.spring_flex.events {
	
	import incubator.spring_flex.dto.Customer;
	
	import mx.events.FlexEvent;
	
	public class CustomerEvent extends FlexEvent {
		
		public static const CUSTOMER_CHANGED:String = "customer_changed";
		public static const CUSTOMER_CREATED:String = "customer_created";
		public static const CUSTOMER_DELETED:String = "customer_deleted";
		public static const CUSTOMER_MODIFIED:String = "customer_modified";

		public var action:String = CUSTOMER_CREATED;
		public var customer:Customer;
		
		public function CustomerEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false) {
            super(type, bubbles, cancelable);
        }
	}
}
