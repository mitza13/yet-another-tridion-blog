using Com.MihaiConsulting.Cache;

namespace MyCacheInvalidator.Example
{
    public class MyCacheInvalidator : ICacheInvalidator
    {
        public void Invalidate(string key)
        {
            string message = "i have been called";
            //perform your own cache removal here
            //cache.Remove(Key);
        }
    }
}