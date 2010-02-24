package incubator.spring_flex.events {
	
	import mx.events.FlexEvent;
	
	public class PageChangeEvent extends FlexEvent {
		
		public static const CUSTOMER_ADD:String = "customer_add";
		public static const HOME:String = "home";
		public static const PHONESEARCH:String = "phonesearch";
		public static const ORDER_SHOW:String = "order_show";
		public static const ORDER_INVOICE:String = "order_invoice";

		public var targetPage:String = HOME;
		
		public function PageChangeEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false) {
            super(type, bubbles, cancelable);
        }
	}
}
