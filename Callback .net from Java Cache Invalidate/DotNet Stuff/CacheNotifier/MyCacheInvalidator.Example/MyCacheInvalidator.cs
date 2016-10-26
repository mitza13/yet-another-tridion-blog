using Com.MihaiConsulting.Cache;

namespace MyCacheInvalidator.Example
{
    public sealed class MyCacheInvalidator : ICacheInvalidator
    {
        public MyCacheInvalidator()
        {
            CacheNotifier.Instance.Invalidator = this;
        }

        public void Invalidate(string cacheElementKey)
        {
            // perform your own cache removal here
            //cache.Remove(cacheElementKey);
        }
    }
}