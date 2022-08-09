//선택한 제품 구매 : 1. 바로 구매 / 2. 장바구니 구매
function itemPay(way){
  let data = {};
  let checkItems = [];
  const itemElement = document.getElementsByClassName("wrap_one_item");
  if(way=='direct'){
    const quantityElement = document.getElementsByClassName("one_item_quantity_su");
    data = {
      checkItems : [parseInt(itemElement[0].id)],
      quantityItems : [parseInt(quantityElement[0].id)],
      way : way
    };
  }
  else if(way=='cart'){
    for(let i=0;i<itemElement.length;i++){
      checkItems.push(parseInt(itemElement[i].id));
    }
    data = {
      checkItems : checkItems,
      way : way
    };
  }
  else return;

  $.ajax({
    contentType: 'application/json',
    url: "/payItem",
    type: "POST",
    data: JSON.stringify(data),
    success: function (data) {
      alert(data["message"]);
      location.replace("/");
    },
    error: function (jqXHR, textStatus, errorThrown){
      alert("다시 시도해주세요.");
    }
  });

}