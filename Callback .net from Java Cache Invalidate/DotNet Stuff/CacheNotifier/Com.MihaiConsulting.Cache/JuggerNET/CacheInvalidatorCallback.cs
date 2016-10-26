using Codemesh.JuggerNET;
using System;
using System.IO;
using System.Reflection;

namespace Com.MihaiConsulting.Cache
{
    public class CacheInvalidatorCallback : JuggerNETProxyObject
    {
        private static JavaClass _cmj_theClass = new JavaClass("com/mihaiconsulting/cache/CacheInvalidatorCallback", typeof(CacheInvalidatorCallback));
        private static JavaMethod _constructor;
        private GenericCallback _callback;
        private ICacheInvalidator _invalidator;

        static CacheInvalidatorCallback()
        {
            using (Stream resourceStream = Assembly.GetExecutingAssembly().GetManifestResourceStream("Com.MihaiConsulting.Cache.JuggerNET.CacheInvalidatorCallback.class"))
            {
                Byte[] buffer = new Byte[resourceStream.Length];
                resourceStream.Read(buffer, 0, (int)resourceStream.Length);

                _cmj_theClass.ByteCode = buffer;
            }

            _constructor = new JavaMethod(_cmj_theClass, null, "<init>", "(J[J)V", false);
        }

        public CacheInvalidatorCallback(ICacheInvalidator cacheInvalidator)
        {
            _invalidator = cacheInvalidator;
            _callback = new GenericCallback((out int return_type, out jvalue return_value, IntPtr input) =>
            {
                try
                {
                    string key = (string)JavaClass.GetTypedInstance(typeof(string), jvalue.From(input).l);
                    _invalidator.Invalidate(key);

                    return_value = new jvalue();
                    return_type = 0;
                }
                catch (Exception exception)
                {
                    return_value = jvalue.CreateCBRetVal(exception);
                    return_type = 1;
                }

                return 0;
            });

            base.JObject = _constructor.construct(0, _callback);
        }
    }
}
