using System;
using System.Security.Claims;
using System.Threading;
using System.Web;

namespace SampleSite
{
    public class MyService : IMyService
    {
        public string GetData()
        {
            //return "hello";
            var id = Thread.CurrentPrincipal.Identity as ClaimsIdentity;
            string result = string.Format("Identity: {0}", id.Name);

            foreach (Claim claim in id.Claims)
            {
                result = string.Format("{0}\r\n{1}", result, claim);
            }

            var user = HttpContext.Current.User;
            result = string.Format("{0}\r\nUser: {1}", result, user.Identity.Name);

            return result;
        }

        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }
    }
}