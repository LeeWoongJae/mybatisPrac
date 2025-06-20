/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]


const basket = {
	// 장바구니 수량 변경.
	changePNum(kw, pnm) {
		console.log(kw);
			//console.log(document.querySelectorAll('i')[0].className);
			//console.log(document.querySelectorAll('i')[1].className);
			
			//[1].parentElement.parentElement.querySelector('input').value
			if(kw=="up"){
				document.querySelector('input[name="p_num'+pnm+']"').value++;
			}else{
				document.querySelector('input[name="p_num'+pnm+']').value--;
			}
		
	},
	// 상품삭제.
	delItem() {

	},
	// 선택상품삭제.
	delCheckedItem() {

	},
	// 장바구니 비우기.
	delAllItem() {

	}
}