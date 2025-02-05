

export const createOrderRequest = (cartItems,userId,addressId,paymentType)=>{
    var date = new Date();
    let request = {};
    request.userId= userId;
    request.addressId = addressId;
    request.orderDate = new Date().toISOString();
    let orderItems = [];
    let amount = 0;
    cartItems?.map((item)=>{
        amount += item?.subTotal; 
        orderItems.push({
            productId: item.productId,
            productVariantId: item?.variant?.id,
            discount: 0,
            quantity: item?.quantity
        })
    });
    request.orderItemRequests = orderItems;
    request.totalAmount =  amount?.toFixed(2);
    request.discount = 0;
    request.paymentMethod= paymentType;
    request.expectedDeliveryDate = new Date(date.setDate(date.getDate()+5)).toISOString();
    request.currency = "usd";
    return request;

}

export const getStepCount = {
    'CREATED':0,
    'PENDING':1,
    'IN_PROGRESS':2,
    'SHIPPED':3,
    'DELIVERED':4
}