import { createBrowserRouter } from "react-router-dom";
import Shop from "./Shop";
import ShopApplicationWrapper from "./pages/ShopApplicationWrapper";
import ProductListPage from "./pages/ProductListPage/ProductListPage";
import ProductCategoryListPage from "./pages/ProductListPage/ProductCategoryListPage" 
import ProductDetails from "./pages/ProductDetailPage/ProductDetails";
import { getProductsByTypeId, loadProductBySlug } from "./routes/products";
import AuthenticationWrapper from "./pages/AuthenticationWrapper";
import Login from "./pages/Login/Login";
import Register from "./pages/Register/Register";
import OAuth2LoginCallback from "./pages/OAuth2LoginCallback";
import Cart from "./pages/Cart/Cart";
import Account from "./pages/Account/Account";
import ProtectedRoute from "./components/ProtectedRoute/ProtectedRoute";
import Checkout from "./pages/Checkout/Checkout";
import ConfirmPayment from "./pages/ConfirmPayment/ConfirmPayment";
import OrderConfirmed from "./pages/OrderConfirmed/OrderConfirmed";
import Profile from "./pages/Account/Profile";
import Orders from "./pages/Account/Orders";
import Settings from "./pages/Account/Settings";
import { AdminPanel } from "./pages/AdminPanel/AdminPanel";
import { ContactUs } from "./pages/ContactUs/ContactUs";
import AboutUs from "./pages/AboutUs/AboutUs";
import Terms from "./pages/T&C/Terms";
import PrivacyPolicy from "./pages/PrivacyPolicy/PrivacyPolicy";
import PaymentPage from "./pages/PaymentPage/PaymentPage";
import ProductSearchListPage from "./pages/ProductListPage/ProductSearchListPage";
import ForgotPassword from "./pages/ForgotPassword/ForgotPassword";
import ResetPassword from "./pages/ForgotPassword/ResetPassword";


export const router = createBrowserRouter([
    {
      path: "/",
      element: <ShopApplicationWrapper />,
      children:[
        {
            path:"/",
            element:<Shop />
        },
        {
            path:"/women",
            element:<ProductListPage categoryType={'WOMEN'}/>,
        },
        {
          path:"/men",
          element:<ProductListPage categoryType={'MEN'}/>,
        },
        {
          path:"/category/Women/:type",
          element:<ProductCategoryListPage categoryType={'WOMEN'}/>,
        },
        {
          path:"/category/Men/:type",
          element:<ProductCategoryListPage categoryType={'MEN'}/>,
        },
        {
          path:"/new/:type",
          element:<ProductCategoryListPage categoryType={'MEN'}/>,
        },
        {
          path:"/products/all",
          element:<ProductCategoryListPage categoryType={'WOMEN'}/>,
        },
        {
          path:"/products/search",
          element: <ProductSearchListPage categoryType={'MEN'} />
        },
        {
          path:"/product/:slug",
          loader: loadProductBySlug,
          element: <ProductDetails />
        },
        {
         path:'/cart-items',
         element: <Cart />
        },
        {
          path:'/account-details/',
          element: <ProtectedRoute><Account /></ProtectedRoute>,
          children:[
            {
              path:'profile',
              element:<ProtectedRoute><Profile/></ProtectedRoute>
            },
            {
              path:'orders',
              element:<ProtectedRoute><Orders/></ProtectedRoute>
            },
            {
              path:'settings',
              element:<ProtectedRoute><Settings /></ProtectedRoute>
            }
          ]
         },
         {
          path:'/checkout',
          element:<ProtectedRoute><Checkout /></ProtectedRoute>
         },
         {
          path:'/orderConfirmed',
          element: <OrderConfirmed />
         },
         {
          path:'/contact-us',
          element: <ContactUs />
         },
         {
          path: '/about',
          element: <AboutUs />
         },
         {
          path: '/terms-conditions',
          element: <Terms />
         },
         {
          path: '/policies',
          element: <PrivacyPolicy />
         }
      ]
    },
    {
      path:"/v1/",
      element:<AuthenticationWrapper />,
      children:[
        {
          path:"login",
          element:<Login />
        },
        {
          path:"register",
          element:<Register />
        },
        {
          path:"forgot-password",
          element:<ForgotPassword />
        },
        {
          path:"reset-password",
          element:<ResetPassword />
        }
      ]
    },
    {
      path:'/oauth2/callback',
      element:<OAuth2LoginCallback />
    },
    // {
    //   path:'/payment',
    //   element:<PaymentPage />
    // },
    {
      path:'/confirmPayment',
      element:<ConfirmPayment />
    },
    {
      path:'/admin/*',
      element:<ProtectedRoute><AdminPanel /></ProtectedRoute>
    }
  ]);
