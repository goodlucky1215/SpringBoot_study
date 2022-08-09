//장바구니 담기
function cartPut(index) {
  $.ajax({
    url: "/AddItemCart",
    type: "POST",
    data: {
      quantity : document.getElementById('item_quantity_buy_'+index).value,
      item : index
    },
    success: function(data){
      alert(data["message"]);
      if(data["result"]) cartGo();
    },
    error: function(){
      alert("다시 시도해주세요.");
    }
  });
}

function cartGo(){
  let choice = confirm("장바구니로 이동하시겠습니까?");
  if(choice) location.href="/cart";
}


//제품 바로 구매
function payPut(index){
  let item_quantity = parseInt(document.getElementById('item_quantity_buy_'+index).value);
  let checkItems = index+","+item_quantity;
  //JSON.stringify(checkItems)
  $.ajax({
    url: "/itemBuy/direct/"+checkItems,
    type: "GET",
    success: function (data) {
      $("#wrap").replaceWith(data);
    },
    error: function (jqXHR, textStatus, errorThrown){
      alert("다시 시도해주세요.");
    }
  });

}
