
package ComplexTypes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import Xml.XmlComplexType;
import Xml.XmlQName;
import Xml.XmlType;

public final class AnimationType
    extends XmlComplexType
{

    protected final static String ALLOWED_CHILDREN_PATTERN = "(((((((asset[ ]+){0,1}(source[ ]+){1,}(sampler[ ]+){1,}(channel[ ]+){1,}(animation[ ]+){0,}){1}|(animation[ ]+){1,}){0,1}){1}|(sampler[ ]+){1,}(channel[ ]+){1,}(animation[ ]+){0,}){1}|(animation[ ]+){1,}){0,1}(extra[ ]+){0,}){1}";
    protected final static HashSet<XmlQName> ALLOWED_CHILDREN_NAMES = new HashSet<XmlQName>();
    protected final static HashMap<XmlQName, XmlQName> CHILDREN_NAME_MAP = new HashMap<XmlQName, XmlQName>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MIN_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<XmlQName, Integer> ALLOWED_CHILDREN_MAX_BOUNDS = new HashMap<XmlQName, Integer>();
    protected final static HashMap<String, String> ATTRIBUTE_DEFAULT_VALUES = new HashMap<String, String>();
    protected final static HashSet<String> ALLOWED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> REQUIRED_ATTRIBUTES = new HashSet<String>();
    protected final static HashSet<String> FORBIDDEN_ATTRIBUTES = new HashSet<String>();
    protected final static HashMap<String, XmlQName> ATTRIBUTES_NAME_MAP = new HashMap<String, XmlQName>();
    protected final static HashMap<String, HashMap<String, XmlType>> KEY_MAPS = new HashMap<String, HashMap<String, XmlType>>();
    protected final static HashMap<String, String> KEY_OWNER_PATH_MAP = new HashMap<String, String>();
    protected final static HashMap<String, String> KEY_VALUE_PATH_MAP = new HashMap<String, String>();
    protected AnimationType[] animation;
    protected ExtraType[] extra;
    protected ChannelType[] channel;
    protected SamplerType[] sampler;
    protected AssetType asset;
    protected SourceType[] source;

    static {
        ALLOWED_ATTRIBUTES.add("name");
        try {
            ATTRIBUTES_NAME_MAP.put("name", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "token"));
            ATTRIBUTES_NAME_MAP.put("id", new XmlQName(new URI("http://www.w3.org/2001/XMLSchema"), "ID"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("0"));
            ALLOWED_CHILDREN_MAX_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), Integer.valueOf("1"));
            ALLOWED_CHILDREN_NAMES.add(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"));
            CHILDREN_NAME_MAP.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"));
            ALLOWED_CHILDREN_MIN_BOUNDS.put(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), Integer.valueOf("0"));
        } catch (URISyntaxException e) {
            throw new AssertionError("URI not parsable", e);
        }
        ALLOWED_ATTRIBUTES.add("id");
    }

    public AnimationType(XmlComplexType elem) {
        super(elem, AnimationType.class);
    }

    public AnimationType[] getAnimation()
        throws IOException
    {
        if (animation == null) {
            try {
                animation = ((AnimationType[]) getChildren(new AnimationType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "animation_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return animation;
    }

    public ExtraType[] getExtra()
        throws IOException
    {
        if (extra == null) {
            try {
                extra = ((ExtraType[]) getChildren(new ExtraType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "extra_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return extra;
    }

    public ChannelType[] getChannel()
        throws IOException
    {
        if (channel == null) {
            try {
                channel = ((ChannelType[]) getChildren(new ChannelType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "channel_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return channel;
    }

    public SamplerType[] getSampler()
        throws IOException
    {
        if (sampler == null) {
            try {
                sampler = ((SamplerType[]) getChildren(new SamplerType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "sampler_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return sampler;
    }

    public AssetType getAsset()
        throws IOException
    {
        if (asset == null) {
            try {
                asset = ((AssetType) getChild(new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "asset_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return asset;
    }

    public SourceType[] getSource()
        throws IOException
    {
        if (source == null) {
            try {
                source = ((SourceType[]) getChildren(new SourceType[ 0 ] , new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source"), new XmlQName(new URI("http://www.collada.org/2008/03/COLLADASchema"), "source_type"), AnimationType.class));
            } catch (URISyntaxException e) {
                throw new AssertionError("URI not parsable", e);
            }
        }
        return source;
    }

}
