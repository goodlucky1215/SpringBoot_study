//화면 켜질때
window.onload = function () {
  const checkboxes = document.getElementsByClassName('checkbox_item');
  itemAllChange(checkboxes.length);
}

//input감지
function cartItemQuantityValueChange(index){
  const itemQuantityBuyElement = document.getElementById('cart_item_quantity_buy_'+index);
  if(isNaN(itemQuantityBuyElement.value)) {
    itemQuantityBuyElement.value=parseInt(item_quantity_hidden.get(index));
    return;
  }
  cartItemQuantityChange('zero',index);
}

//카트에 담은 아이템 수 변경
function cartItemQuantityChange(button,index) {
  const cartItemQuantityBuyElement = document.getElementById('cart_item_quantity_buy_'+index);//아이템 구매 갯수
  const itemQuantityBuyPriceElement = document.getElementById('item_quantity_buy_price_'+index);//아이템 구매 합계 가격
  let cart_item_quantity_buy = parseInt(cartItemQuantityBuyElement.value);

  if(button=='plus' || (button=='minus' && 1<cart_item_quantity_buy) || button=='zero') {
    let qu = button == 'plus' ? 1 : (button =='minus' ? -1:0);
    $.ajax({
      url: "/cartItemUpdate",
      type: "POST",
      data: {
        quantity: cart_item_quantity_buy+qu,
        item: index
      },
      success: function (data) {
        if(data["result"]){
          cart_item_quantity_buy = data["cart"]["quantity"];
          cartItemQuantityBuyElement.value = cart_item_quantity_buy;
          item_quantity_hidden.set(index,cart_item_quantity_buy);
          itemQuantityBuyPriceElement.innerText = data["cart"]["item"].price * cart_item_quantity_buy;
          item_price_hidden.set(index,data["cart"]["item"].price * cart_item_quantity_buy);
          checkboxClick();
        }else {
          cartItemQuantityBuyElement.value = item_quantity_hidden.get(index);
          itemQuantityBuyPriceElement.innerText = item_price_hidden.get(index);
          alert(data["message"]);
        }
      },
      error: function (jqXHR, textStatus, errorThrown){
        alert("다시 시도해주세요.");
      }
    });
  }
}



//제품 삭제 - 체크된 상품
function cartItemDeleteCheckBox(){
  let choice = confirm("삭제하시겠습니까?");
  if(choice) cartItemDeleteList();
}

function cartItemDeleteList(){
  let checkItems = [];
  const checkBoxItemElement = document.getElementsByClassName("checkbox_item");
  for(let i=0;i<checkBoxItemElement.length;i++){
    if(checkBoxItemElement[i].checked) checkItems.push(parseInt(checkBoxItemElement[i].id));
  }
  if(checkItems.length==0) {
    alert("선택한 제품을 확인해주세요.");
    return;
  }
  cartItemDelete(checkItems);
}

//제품 삭제 - 품절 상품
function cartItemDeleteZero(index){
  let checkItems = [parseInt(index)];
  cartItemDelete(checkItems);
}

function cartItemDelete(checkItems){
  $.ajax({
    contentType: 'application/json',
    url: "/cartItemDelete",
    type: "POST",
    data: JSON.stringify(checkItems),
    success: function (data) {
      if(data["result"]) location.replace("/cart");
      else alert(data["message"]);
    },
    error: function (jqXHR, textStatus, errorThrown){
      alert("다시 시도해주세요.");
    }
  });

}

//선택한 제품 구매
function cartItemBuy(){
  let checkItems = [];
  const checkBoxItemElement = document.getElementsByClassName("checkbox_item");
  for(let i=0;i<checkBoxItemElement.length;i++){
    if(checkBoxItemElement[i].checked) checkItems.push(parseInt(checkBoxItemElement[i].id));
  }
  //체크된 제품이 없으면 모든 제품 구매
  if(checkItems.length==0){
    for(let i=0;i<checkBoxItemElement.length;i++){
      checkItems.push(parseInt(checkBoxItemElement[i].id));
    }
  }

  if(checkItems.length==0) {
    alert("장바구니에 제품이 없습니다.");
    return;
  }
  const itemList = checkItems.join();

  $.ajax({
    url: "/itemBuy/cart/"+itemList,
    type: "GET",
    success: function (data) {
        $("#wrap").replaceWith(data);
    },
    error: function (jqXHR, textStatus, errorThrown){
      alert("다시 시도해주세요.");
    }
  });

}

//모든 상품 체크박스 선택
function selectAll(group){
  const checkboxes = document.getElementsByClassName('checkbox_item'+group);
  let check = false;
  for(let checkbox of checkboxes){
    if(checkbox.checked===false){
      check =true;
      break;
    }
  }
  if(check){
    for(let checkbox of checkboxes){
      checkbox.checked=true;
    }
  }
  else{
    for(let checkbox of checkboxes){
      checkbox.checked=false;
    }
  }

  if(group=="")itemAllChange(checkboxes.length);
  else checkboxClick();
}

//체크 박스 클릭에 따른 이벤트
function checkboxClick(){
  const checkboxes = document.getElementsByClassName('checkbox_item');
  const itemKindAll = document.getElementById('cart_buy_item_kind_all'); //총 종류
  const itemQuantityAll = document.getElementById('cart_buy_item_quantity_all'); //총 개수
  const itemQuantityOne = document.getElementsByClassName('cart_item_quantity_buy'); //상품 각각 개수

  //총 상품 수 & 총 수량
  let itemKindAllSu = 0;
  let itemQuantityAllSu = 0;
  for(let i=0;i<checkboxes.length;i++){
    if(checkboxes[i].checked){
      itemKindAllSu++;
      itemQuantityAllSu+=parseInt(itemQuantityOne[i].value);
    }
  }

  //하나도 선택된 아이템이 없다면 총 금액으로
  if(itemKindAllSu===0){
    itemAllChange(checkboxes.length);
    return;
  }

  //총 금액
  const priceAll = document.getElementById('cart_buy_item_price_all');
  let price = 0;
  price += itemsBuyChange2('ssgdelivery');
  price += itemsBuyChange2('dawndelivery');
  price += itemsBuyChange2('delivery');

  priceAll.innerText = price;
  itemKindAll.innerText = itemKindAllSu;
  itemQuantityAll.innerText = itemQuantityAllSu;


}

//모든 상품 선택에 따른 총 결제 계산
function itemAllChange(checkboxLength){
  const priceAll = document.getElementById('cart_buy_item_price_all'); //총 금액
  const itemKindAll = document.getElementById('cart_buy_item_kind_all'); //총 종류
  const itemQuantityAll = document.getElementById('cart_buy_item_quantity_all'); //총 개수
  let price = 0;
  price += itemsBuyChange('ssgdelivery');
  price += itemsBuyChange('dawndelivery');
  price += itemsBuyChange('delivery');
  priceAll.innerText = price;
  itemKindAll.innerText = checkboxLength;
  itemQuantityAll.innerText = itemQuantityChange();
}

//그룹별 결제 총 금액 - 모든 상품
function itemsBuyChange(group){
  const groupAllPrice = document.getElementById('item_price_all_'+group);
  const groupOnePrice = document.getElementsByClassName('item_quantity_buy_price_'+group);
  if(groupOnePrice.length===0) return parseInt(0);
  let price = 0;
  for(let p of groupOnePrice){
    price += parseInt(p.innerText);
  }
  groupAllPrice.innerText = price;
  return price;
}

//그룹별 결제 총 금액 - 부분 상품
function itemsBuyChange2(group){
  const checkboxes = document.getElementsByClassName('checkbox_item_'+group);
  const groupAllPrice = document.getElementById('item_price_all_'+group);
  const groupOnePrice = document.getElementsByClassName('item_quantity_buy_price_'+group);
  if(groupOnePrice.length===0) return parseInt(0);
  let price = 0;
  for(let i=0;i<checkboxes.length;i++){
    if(checkboxes[i].checked) price += parseInt(groupOnePrice[i].innerText);
  }

  groupAllPrice.innerText = price;
  return price;
}


//총 수량 개수
function itemQuantityChange(){
  const itemsQuantity = document.getElementsByClassName('cart_item_quantity_buy');
  let qu = 0;
  for(let quantity of itemsQuantity){
    qu += parseInt(quantity.value);
  }
  return qu;
}