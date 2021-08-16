<%@page import="com.koreait.shoppingmall.domain.PayMethod"%>
<%@page import="com.koreait.shoppingmall.domain.Product"%>
<%@page import="com.koreait.shoppingmall.domain.Cart"%>
<%@page import="com.koreait.shoppingmall.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<TopCategory> topList=(List)request.getAttribute("topList");	
	List<Cart> cartList=(List)request.getAttribute("cartList");	
	List<PayMethod> payMethodList=(List)request.getAttribute("payMethodList");	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Checkout</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="/resources/client/css/core-style.css">
    <link rel="stylesheet" href="/resources/client/style.css">

    <!-- Responsive CSS -->
    <link href="css/responsive.css" rel="stylesheet">

</head>

<body>
	<%@ include file="../inc/side_category.jsp" %>
    <div id="wrapper">

        <!-- ****** Header Area Start ****** -->
        <%@ include file="../inc/header.jsp" %>
        <!-- ****** Header Area End ****** -->

        <!-- ****** Top Discount Area Start ****** -->
        <%@ include file="../inc/discount_banner.jsp" %>
        <!-- ****** Top Discount Area End ****** -->

        <!-- ****** Checkout Area Start ****** -->
        <div class="checkout_area section_padding_100">
            <div class="container">
                <form id="form1" method="post">
                <div class="row">

                    <div class="col-12 col-md-6">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-page-heading">
                                <h5>받으실 분 정보</h5>
                                <p>Enter your cupone code</p>
                            </div>

                                <div class="row">
                                    <div class="col-md-12 mb-3">
                                        <input type="text" class="form-control" id="first_name" name="name" placeholder="받는 사람 이름" required >
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="street_address">Address <span>*</span></label>
                                        <input type="text" class="form-control mb-3" id="street_address" name="addr1"  placeholder="주소">
                                        <input type="text" class="form-control" id="street_address2" name="addr2"  placeholder="나머지 주소">
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="postcode">Postcode <span>*</span></label>
                                        <input type="text" class="form-control" id="postcode" name="zipcode" placeholder="우편번호">
                                    </div>
                                    <div class="col-4 mb-3">
                                        <input type="number" class="form-control" name="phone1" min="0" placeholder="국번">
                                    </div>
                                    <div class="col-4 mb-3">
                                        <input type="number" class="form-control" name="phone2" min="0" placeholder="앞 4자리">
                                    </div>
                                    <div class="col-4 mb-3">
                                        <input type="number" class="form-control" name="phone3" min="0"  placeholder="뒷 4자리">
                                    </div>
                                    
                                </div>
                            
                        </div>
                    </div>

                    <div class="col-12 col-md-6 col-lg-5 ml-lg-auto">
                        <div class="order-details-confirmation">

                            <div class="cart-page-heading">
                                <h5>Your Order</h5>
                                <p>The Details</p>
                            </div>

                            <ul class="order-details-form mb-4">
                                <li><span>Product</span> <span>Total</span></li>
                                <%
                                	int total_buy=0; //총 구매금액 
									int shipping=5000; //배송비                                        		
                                	int total_pay=0; //실제 결제할 금액(각종 할인 등을 적용하여 차감한 결과 또는 배송비에 의해 추가될 수도 있슴)
                                %>
                                <%for(int i=0;i<cartList.size();i++){ //구매한 상품의 수만큼 반복%>
                                <%Cart cart=cartList.get(i); %>
                                <%Product product=cart.getProduct(); %>
                                <%total_buy+= product.getPrice()*cart.getEa();%>
                                <li><span><%=product.getProduct_name() %> x <%=cart.getEa()%></span> <span><%=product.getPrice()*cart.getEa() %></span></li>
                                <%} %>
                                <li><span>Subtotal(총 구매금액)</span> <span><%=total_buy %></span></li>
                                <li><span>Shipping</span> <span><%=shipping %></span></li>
                                <%total_pay=total_buy-shipping; //각종 포인트 등을 추후 계산... %>
                                <li><span>Total(총 결제금액)</span> <span><%=total_pay %></span></li>
                            </ul>


                            <div id="accordion" role="tablist" class="mb-4">
                                <%for(PayMethod payMethod : payMethodList){ %>
                                <div class="card">
                                    <div class="card-header" role="tab" id="headingOne">
                                        <h6 class="mb-0">
                                            <a data-toggle="collapse" onClick="setPayMethod(<%=payMethod.getPaymethod_id() %>)" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne"><i class="fa fa-circle-o mr-3"></i><%=payMethod.getName() %></a>
                                        </h6>
                                    </div>

                                    <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
                                        <div class="card-body">
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integ er bibendum sodales arcu id te mpus. Ut consectetur lacus.</p>
                                        </div>
                                    </div>
                                </div>
                                <%} %>
                            </div>

                            <a href="javascript:order()" class="btn karl-checkout-btn">Place Order</a>
                        </div>
                    </div>
                    
                    <input type="hidden" name="total_buy" value="<%=total_buy%>">
                    <input type="hidden" name="total_pay" value="<%=total_pay%>">
                    <input type="hidden" name="paymethod_id">
                </div>
			</form>
            </div>
        </div>
        <!-- ****** Checkout Area End ****** -->

        <!-- ****** Footer Area Start ****** -->
        <footer class="footer_area">
            <div class="container">
                <div class="row">
                    <!-- Single Footer Area Start -->
                    <div class="col-12 col-md-6 col-lg-3">
                        <div class="single_footer_area">
                            <div class="footer-logo">
                                <img src="img/core-img/logo.png" alt="">
                            </div>
                            <div class="copywrite_text d-flex align-items-center">
                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Area Start -->
                    <div class="col-12 col-sm-6 col-md-3 col-lg-2">
                        <div class="single_footer_area">
                            <ul class="footer_widget_menu">
                                <li><a href="#">About</a></li>
                                <li><a href="#">Blog</a></li>
                                <li><a href="#">Faq</a></li>
                                <li><a href="#">Returns</a></li>
                                <li><a href="#">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- Single Footer Area Start -->
                    <div class="col-12 col-sm-6 col-md-3 col-lg-2">
                        <div class="single_footer_area">
                            <ul class="footer_widget_menu">
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Shipping</a></li>
                                <li><a href="#">Our Policies</a></li>
                                <li><a href="#">Afiliates</a></li>
                            </ul>
                        </div>
                    </div>
                    <!-- Single Footer Area Start -->
                    <div class="col-12 col-lg-5">
                        <div class="single_footer_area">
                            <div class="footer_heading mb-30">
                                <h6>Subscribe to our newsletter</h6>
                            </div>
                            <div class="subscribtion_form">
                                <form action="#" method="post">
                                    <input type="email" name="mail" class="mail" placeholder="Your email here">
                                    <button type="submit" class="submit">Subscribe</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="line"></div>

                <!-- Footer Bottom Area Start -->
                <div class="footer_bottom_area">
                    <div class="row">
                        <div class="col-12">
                            <div class="footer_social_area text-center">
                                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="/resources/client/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="/resources/client/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="/resources/client/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="/resources/client/js/plugins.js"></script>
    <!-- Active js -->
    <script src="/resources/client/js/active.js"></script>
	<script type="text/javascript">
		//고객이 선택한 결제방법 
		function setPayMethod(paymethod_id){
			//전송하기 위해 히든에 보관하자!!!
			$("#form1 input[name='paymethod_id']").val(paymethod_id);
		}
		
		//주문 요청!!
		function order(){
			if(confirm("입력하신 주문정보로 결제를 진행할까요?")){
				$("#form1").attr({
					action:"/client/checkout/pay",
					method:"POST"
				});
				$("#form1").submit();			
			}
		}	
	</script>
</body>

</html>
