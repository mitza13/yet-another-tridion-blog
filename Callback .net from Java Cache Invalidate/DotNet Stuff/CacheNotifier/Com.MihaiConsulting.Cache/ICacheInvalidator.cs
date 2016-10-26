namespace Com.MihaiConsulting.Cache
{
    public interface ICacheInvalidator
    {
        void Invalidate(string key);
    }
}
