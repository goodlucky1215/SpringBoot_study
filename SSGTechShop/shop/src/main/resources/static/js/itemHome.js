//장바구니 담기
function cartPut(index) {
  var ItemPutForm = JSON.stringify({
    quantity : parseInt(document.getElementById('item_quantity_buy_'+index).value),
    member : 1,
    item :  parseInt(index)
  });

  $.ajax({
    url: "/AddItemCart",
    type: "POST",
    contentType : "application/json",
    data: ItemPutForm,
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
